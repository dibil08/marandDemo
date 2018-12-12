

# Running the app
To run the app you just have to execute demo-0.0.1-SNAPSHOT.jar 

on windows, just double click the jar

on linux add execute rights with chmod +x and then run it

# API
It's accesed on http://localhost:8080/api

## API test
If you are using postman, just import demoMarand.postman_collection and run it. 

If not, here are sample querries

GET:

http://localhost:8080/api/prescriptions
http://localhost:8080/api/prescriptions/1
http://localhost:8080/api/prescriptions/1/administrations

DELETE:

http://localhost:8080/api/prescriptions/3

POST:

http://localhost:8080/api/prescriptions

with json body:

{
    "name": "Nov lekadol",
    "unit": 200,
    "start_time": "2018-06-15T11:30:00",
    "end_time": "2018-06-17T16:00:00",
    "timing_hours_period": 3
}

PUT:
http://localhost:8080/api/prescriptions/1

with json body:

{
    "name": "Lekadsaddol",
    "unit": 500,
    "start_time": "2018-06-15T18:00:00,",
    "end_time": "2018-06-16T18:00:00,",
    "timing_hours_period": 1
}

## API functions
GET

http://localhost:8080/api/prescriptions   (gets all prescriptions)
http://localhost:8080/api/prescriptions/{id}   (gets prescription with given id)
http://localhost:8080/api/prescriptions/{id}/administrations   (gets prescription administration times for given id)

DELETE

http://localhost:8080/api/prescriptions/{id}   (delete prescription with given id)

PUT

http://localhost:8080/api/prescriptions/{id}   (update prescription with given id)

POST

http://localhost:8080/api/prescriptions   (add prescription)
