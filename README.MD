# Triangle Discovery
- This app is about to infer the triangle type based on input of triangle sizes, it define if the triangle is invalid, or if it's valid and the type.

# Project Structure
- The project structure is based on [clean architecture](http://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html) that basically consists of the modularization of the design to decouple the technologies.
- The project modules are:
```
application - Contains the framework application boot and the integration tests
usecases - Contains all the main business rules
web - Contains the Controllers and Rest technologies implementations
```
# Technologies
- I'm using to solve this problem the following technologies:
    - Spring Boot
    - Java 8
    - JUnit for testing
    - Lombok to automate getters and setters
``` ```
# Endpoints
- health - ```/health``` GET
- discover ```/discover``` POST
```
Payload example:
{
    "size1": 2.0,
    "size2": 3.0,
    "size3": 5.0
}

Possible Responses:
{
    "type": "SCALENE"
}

{
    "type": "EQUILATERAL"
}

{
    "type": "ISOSCELES"
}


{
    "status": "failed",
    "reason": "The Side Values Can't be 0 or less"
}

{
    "status": "failed",
    "reason": "Invalid triangle format"
}
```

# HOW TO MAKE IT BETTER?
 - Create persistence module and save historical output
 - Make Cache layer
 - Support list of triangles and make parallel processing
 - Host on AWS using elasticbeanstalk, ecs or kubernetes
