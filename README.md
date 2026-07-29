#  Golf Course & Member Management Service

A containerized Spring Boot REST API for managing golf course memberships and tournaments.

## 1. Search & API Endpoints

The search endpoints I have built are:

GET http://localhost:8080/api/member/memberlist - Retrieves a full list of registered members.

**Example Response for above:**
```json
[
  {
    "id": 1,
    "name": "Jane Doe",
    "mailingAddress": "123 Golf Club Rd",
    "email": "jane.doe@example.com",
    "phoneNumber": "555-0199",
    "membershipStartDate": "2023-05-15",
    "membershipType": "lifetime"
  }
]
```
*Other Search Endpoints:*

**Member**

* GET http://localhost:8080/api/member/search/name/{name} - Retrieves a member by their name. 
* GET http://localhost:8080/api/member/search/type/{type} - Retrieves a list of members by membership type.
* GET http://localhost:8080/api/member/search/phone/{phonenumber} - Retrieves a member by their phone number.
* GET http://localhost:8080/api/member/search/tournament/startdate/{startdate} - Retrieves a list of registered member by tournament start date.

**Tournament**

* GET http://localhost:8080/api/tournament/tournamentlist - Retrieves a list of tournaments.
* GET http://localhost:8080/api/tournament/search/startdate/{startdate} - Retrieves a list of tournaments by start date.
* GET http://localhost:8080/api/tournament/search/location/{location} - Retrieves a list of tournaments by location.

To use these endpoints, download and run postman. Create a new request. Select when CRUD method you want to use, and paste one of the above endpoints in the URL bar, hit send to receive a response.

## 2. Installation & Docker Setup

### Step 1: Pull the Docker Image

In your IDE terminal run command:
Pull image
```bash
docker pull justinseaward89/golfcourse:latest
```

or Build the image localy
```bash
docker build -t golfcourse-api:latest .
```

### Step 2: Run the Container
Run the following command to start the container on port `8080`:
```bash
docker run -p 8080:8080 -e DB_USERNAME='your_username_here' -e DB_PASSWORD='your_password_here' justinseaward89/golfcourse:latest
```

Docker container should now be running.


## 3. AWS RDS Connection

First I created a MySql database instance in AWS RDS. Then configured a security group to allow inbound traffic on the database port. I updated the JDBC URL in the application.properties file to point to my AWS endpoint instead of localhost. When Spring boot starts up the JDBC driver uses the URL, username and password to connect to the AWS RDS and establish a connect pool so the API can query the database. 

---

##  4. Challenges & Troubleshooting

### Issue: CLI Password Parsing Error (`Access Denied`).
* Problem: I ran into a problem when trying to connect to the AWS database through the CLI. Spring boot kept throwing a 'Access Denied' error because there are special characters in the password.
  Cause: This problem was caused by the lack of single quotes around the password ('password'). The CLI was interrupting the special characters instead of just parsing the password.
  Solution: Wrapped the username and password value in single quotes ('password') when entering the credentials in the terminal, to enforce strong quoting, telling the terminal to treat every character literally and ignore special programming symbols. 

*Example correct syntax below*
  ```bash
  docker run -e DB_USERNAME='username' -e DB_PASSWORD='<=password!>' justinseaward89/golfcourse:latest
```
