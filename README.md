# Response Entity
the response entity is used to manipulate the body of the response it is used to modify the headers, body, http status etc. of the response.

We can write it like 
<U><B>ResponseEntity<T></B></U> like any other return type of the function in the controller
here T can be of any type be it custom or any other class. 

We can also write <U><B>ResponseEntity<?></B></U> if we are not sure what the return type is going to be.

The conclusion is we use the response entity to play or manipulate or modify the response body, headers, status codes, etc.

# Lombok

Now lombok is generally used to reduce the boilerplate code which we use to write which was getter, setter, constructor's etc.

with the help of lombok, it is automatically generated at the compile time we don't need to write anything manually, 
instead we only need to add one annotation on top of the class @Data annotation from lombok so that it can generate all the getters, setters, etc. by itself on compile time.

now @Data internally contains annotations such as the @Getter @Setter etc. in itself, so we can use them individually as well.