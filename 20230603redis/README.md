# Refer
https://github.com/dinhkhiemtran/redis_cache_session_demo_spring_boot/blob/develop/src/main/java/com/khiemtran/redis_demo_spring_boot/service/imp/UserRedisServiceImp.java

<br>
<br>

# Redis Database

Redis hash is a data structure in Redis that allows you to store and manage field-value pairs. It is similar to a dictionary or a map in other programming languages. In Redis, a hash is identified by a key and consists of multiple fields, each associated with a value.

Here are some key characteristics of Redis hash:

1. Key: A unique identifier for the hash. You can use this key to access and manipulate the hash data.

2. Field: Each field within a hash is a string that holds a specific value. Fields are unique within a hash.

3. Value: The value associated with each field in the hash. Redis supports various data types as values, such as strings, numbers, lists, sets, and even other hashes.


Redis provides a rich set of commands to operate on hashes. Some commonly used commands include:

`HSET key field value`: Sets the value of a field in a hash.

`HGET key field`: Retrieves the value of a field from a hash.

`HGETALL key`: Retrieves all fields and their values from a hash.

`HDEL key field [field ...]`: Deletes one or more fields from a hash.

`HINCRBY key field increment`: Increments the value of a field by a specified increment.

`HKEYS key`: Retrieves all the field names from a hash.

`HVALS key`: Retrieves all the values from a hash.



```
# Set the value of fields in a hash
> HSET cart:123 product1 5
(integer) 1
> HSET cart:123 product2 3
(integer) 1

# Get the value of a specific field in the hash
> HGET cart:123 product1
"5"

# Get all fields and values in the hash
> HGETALL cart:123
1) "product1"
2) "5"
3) "product2"
4) "3"

# Delete a field from the hash
> HDEL cart:123 product2
(integer) 1

# Increment the value of a field
> HINCRBY cart:123 product1 2
(integer) 7

# Get all field names in the hash
> HKEYS cart:123
1) "product1"

# Get all values in the hash
> HVALS cart:123
1) "7"
```
<br>

# install Redis on Windows\

https://redis.io/docs/getting-started/installation/install-redis-on-windows/ 


# include >2 param in url in springboot controller

Using Path Variables:
You can include multiple path variables in the URL by defining them within curly braces `{}` in the URL pattern. Each path variable should have a corresponding method parameter in the controller method.

Example:
```
@GetMapping("/users/{userId}/orders/{orderId}")
public ResponseEntity<Order> getOrder(
        @PathVariable("userId") Long userId,
        @PathVariable("orderId") Long orderId) {
    // ...
}
```

In the above example, the URL pattern `/users/{userId}/orders/{orderId}` includes two path variables: userId and orderId. These path variables are extracted using @PathVariable annotations and are mapped to the method parameters userId and orderId respectively.

The URL for accessing this controller method would be something like: `/users/123/orders/456`, where `123` represents the `userId` and `456` represents the `orderId`.

Using Query Parameters:
You can include multiple query parameters in the URL by appending them to the URL with the format `?param1=value1&param2=value2`. Each query parameter should have a corresponding method parameter in the controller method.

Example:

```
@GetMapping("/users/orders")
public ResponseEntity<Order> getOrder(
        @RequestParam("userId") Long userId,
        @RequestParam("orderId") Long orderId) {
    // ...
}

```

In the above example, the URL pattern `/users/orders` includes no path variables. Instead, the parameters `userId` and `orderId` are specified as query parameters. These query parameters are extracted using `@RequestParam` annotations and are mapped to the method parameters `userId` and `orderId` respectively.

The URL for accessing this controller method would be something like: `/users/orders?userId=123&orderId=456`.

