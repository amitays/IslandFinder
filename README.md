# IslandFinder
RESTFul Service for building and identifying islands on a bit map
Builed using Spring Rest and Spring Boot, in order to run the service outside of the IDE, use the maven command:
 ```mvn spring-boot:run```

## Endpoints:
### islandfinder/randommap:
Use the givan width and hight in order to generate a widthXhight sized boolean map where the tru values represent land
#### Curl example command:
```curl -X POST http://localhost:8080/islandfinder/randommap/ -F hight=2 -F width=2```
#### JSON Response:
```{"map":[[true,true],[true,false]]} ```

### islandfinder/identify:
Read the givan map in request body, run the Island Identification algorithem and return a list of lslands, each island, is acollection of coordinates. 
#### Curl example command:
```curl -X POST http://localhost:8080/islandfinder/identify/ -H "Content-Type: application/json" -d '{"map":[[false,true],[true,false]]}' ```
#### JSON Response:
```[{"coordinates":[{"longitude":1,"latitude":0},{"longitude":0,"latitude":1}]}]```

## Note:
The curl commands can be stacked in order to solve a random BitMap:
* ```curl -X POST http://localhost:8080/islandfinder/randommap/ -F hight=2000 -F width=4000 -o bitMap.json ```
* ```curl -X POST http://localhost:8080/islandfinder/identify/ -H "Content-Type: application/json" -d "@bitMap.json" ```

