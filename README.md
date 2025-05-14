# Response Entity
the response entity is used to manipulate the body of the response it is used to modify the headers, body, http status etc of the response.

We can write it like 
<U><B>ResponseEntity<T></B></U> like any other return type of the function in the controller
here T can be of any type be it custom or any other class. 

We can also write <U><B>ResponseEntity<?></B></U> if we are not sure what the return type is going to be.

The conclusion is we use the response entity to play or manipulate or modify the response body, headers, status codes etc.
