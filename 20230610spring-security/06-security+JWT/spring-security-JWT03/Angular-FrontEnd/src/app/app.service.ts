import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Cookie } from 'ng2-cookies';
import { Observable, throwError } from 'rxjs';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import { catchError } from 'rxjs/operators';


/**
 *  retrieveToken(): to obtain access token using authorization code
    saveToken(): to save our access token in a cookie using ng2-cookies library
    getResource(): to get a Foo object from server using its ID
    checkCredentials(): to check if user is logged in or not
    logout(): to delete access token cookie and log the user out
 */

    export class Foo {
      constructor(
        public id: number,
        public name: string) { }
    } 
    
    @Injectable()
    export class AppService {
       public clientId = 'newClient';
       public clientSecret = 'newClientSecret';
       public redirectUri = 'http://localhost:8089/';
    
      constructor(
        private _http: HttpClient){}
    
      retrieveToken(code){
        let params = new URLSearchParams();   
        params.append('grant_type','authorization_code');
        params.append('client_id', this.clientId);
        params.append('redirect_uri', this.redirectUri);
        params.append('code',code);
    
        let headers = new HttpHeaders({'Content-type': 'application/x-www-form-urlencoded; charset=utf-8'});
         this._http.post('http://localhost:8083/auth/realms/baeldung/protocol/openid-connect/token', params.toString(), { headers: headers })
        .subscribe(
          data => this.saveToken(data),
          err => alert('Invalid Credentials')
        ); 
      }
    
      saveToken(token){
        var expireDate = new Date().getTime() + (1000 * token.expires_in);
        Cookie.set("access_token", token.access_token, expireDate);
        Cookie.set("id_token", token.id_token, expireDate);
        console.log('Obtained Access token');
        window.location.href = 'http://localhost:8089';
      }
    
      getResource(resourceUrl) : Observable<any>{
        var headers = new HttpHeaders({'Content-type': 'application/x-www-form-urlencoded; charset=utf-8', 'Authorization': 'Bearer '+Cookie.get('access_token')});
        return this._http.get(resourceUrl, { headers: headers })
                          .pipe(
                            catchError((error: any) => {
                              return throwError(error?.error || 'Server error');
                            })                     
                          );
      }
    
      checkCredentials(){
        return Cookie.check('access_token');
      } 
    
      logout() {
        let token = Cookie.get('id_token');
        Cookie.delete('access_token');
        Cookie.delete('id_token');
        let logoutURL = "http://localhost:8083/auth/realms/baeldung/protocol/openid-connect/logout?id_token_hint="
          + token
          + "&post_logout_redirect_uri=" + this.redirectUri;
    
        window.location.href = logoutURL;
      } 
    }
    