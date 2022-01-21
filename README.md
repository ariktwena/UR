<h1 align="center">MeeW Case</h1>

<h4 align="center">Job Interview</h4>

[![Build Status](https://app.travis-ci.com/ariktwena/Meew.svg?token=pepPqVzg9ADy2wZERUTz&branch=master)](https://app.travis-ci.com/ariktwena/Meew)

## Author

👤 **Arik Gaarde Nielsen**

* [Github](https://github.com/ariktwena)
* [LinkedIn](https://www.linkedin.com/in/arik-gaarde-nielsen-3a54255/)

# Deployed project

#### 🖥 [FrontEnd](https://codeops.dk/)

#### 💾 [BackEnd](https://codergram.dk/Meew/)

#### 🖥 [GitHub FrontEnd](https://github.com/ariktwena/Meew/tree/master/Frontend)

#### 💾 [GitHub BackEnd](https://github.com/ariktwena/Meew)

#### 👮🏽‍♂️ [Travis](https://app.travis-ci.com/github/ariktwena/Meew)

## Using this project

As a non registered user, you can Spin a Wheel and get the result as JSON.

If you are a registered user (admin), you can generate individual Wheels, get Player, Company lists, plus get Spin Stats. You will get the information as JSON. Use the JWT in your request header under ""x-access-token". 

  <table>
    <thead>
      <tr>
      	 <th>Privilege</th>
        <th>Method</th>
        <th>URL</th>
        <th>Request(JSON)</th>
        <th>Response(JSON)</th>
        <th>Error(e)</th>
      </tr>
    </thead>
    <tbody>
    <tr>
      <td>admin</td>
        <td>POST</td>
        <td>https://codergram.dk/Meew/api/login</td>
        <td>
        	{
   			 "username": String,
   			 "password": String
			}
        </td>
        <td>
        {
   			 "username": String,
   			 "token": String
			}
        </td>
        <td>
        {
    "code": 403,
    "message": "Invalid user name or password"
}
        </td>
      </tr>
      <tr>
      <td>admin</td>
        <td>POST</td>
        <td>https://codergram.dk/Meew/api/wheel</td>
        <td>
        	{
    "wheelName": String,
    "fields": [
        {
            "prizeName": String,
            "prizeValue": Float
        },...
    ],
    "company": {
        "companyName": String
    }
}
        </td>
        <td>
        {
    "id": Integer,
    "wheelName": String,
    "fields": [
        {
            "id": Integer,
            "prizeName": String,
            "prizeValue": Float
        },...
    ],
    "company": {
        "id": Integer,
        "companyName": String
    },
    "spins": []
}
        </td>
        <td>
        {
    "code": 500,
    "message": "Internal Server Problem. We are sorry for the inconvenience"
}
        </td>
      </tr>
      <tr>
      <td>users</td>
        <td>POST</td>
        <td>https://codergram.dk/Meew/api/wheel/{id}</td>
        <td>
{
    "playerName": String,
    "email": String
}
        </td>
        <td>
        {
    "id": Integer,
    "fieldNumbers": Integer,
    "arcSize": Float,
    "top": Integer,
    "offSet": Float,
    "rotate": Float,
    "resultNumber": Integer,
    "resultName": String,
    "resultValue": Float,
    "player": {
        "id": Integer,
        "playerName": String,
        "email": String
    },
    "wheel": {
        "id": Integer,
        "wheelName": String,
        "fields": [
            {
                "id": Integer,
                "prizeName": String,
                "prizeValue": Float
            },...
        ],
        "company": {
            "id": Integer,
            "companyName": String
        },
        "spins": []
    },
    "date": {
        "year": Integer,
        "month": Integer,
        "day": Integer
    }
}        </td>
        <td>
        {
    "code": 500,
    "message": "Internal Server Problem. We are sorry for the inconvenience"
}
        </td>
      </tr>
      <tr>
        <td>admin</td>
        <td>GET</td>
        <td>https://codergram.dk/jobsamtale/api/morsecode</td>
        <td></td>
        <td>
        [
		    {
		        "id": Number,
		        "codeKey": String,
		        "codeValue": String
		    },
		    {
		        "id": Number,
		        "codeKey": String,
		        "codeValue": String
		    },...
		  ]
      </td>
      <td>
      	{
    		"code": 500,
    		"message": "Internal Server Problem. We are sorry for the inconvenience"
		}
      </td>
      </tr>
      <tr>
      <td>admin</td>
        <td>GET</td>
        <td>https://codergram.dk/Meew/api/wheel/{id}</td>
        <td>
        </td>
        <td>
        {
    "id": Integer,
    "wheelName": String,
    "fields": [
        {
            "id": Integer,
            "prizeName": String,
            "prizeValue": Float
        },...
    ],
    "company": {
        "id": Integer,
        "companyName": String
    },
    "spins": []
}
        </td>
        <td>
        {
    "code": 404,
    "message": "No Wheel with id: {id} exists"
}
        </td>
      </tr>
      <tr>
      <td>admin</td>
        <td>GET</td>
        <td>https://codergram.dk/Meew/api/wheel</td>
        <td>
        </td>
        <td>
        [
        {
    "id": Integer,
    "wheelName": String,
    "fields": [
        {
            "id": Integer,
            "prizeName": String,
            "prizeValue": Float
        },...
    ],
    "company": {
        "id": Integer,
        "companyName": String
    },
    "spins": [
    {
    "id": Integer,
    "fieldNumbers": Integer,
    "arcSize": Float,
    "top": Integer,
    "offSet": Float,
    "rotate": Float,
    "resultNumber": Integer,
    "resultName": String,
    "resultValue": Float,
    "player": {
        "id": Integer,
        "playerName": String,
        "email": String
    },
    "wheel": {
        "id": Integer,
        "wheelName": String,
        "fields": [
            {
                "id": Integer,
                "prizeName": String,
                "prizeValue": Float
            },...
        ],
        "company": {
            "id": Integer,
            "companyName": String
        },
        "spins": []
    },...
    ]
},...
]
        </td>
        <td>
   	{
    		"code": 500,
    		"message": "Internal Server Problem. We are sorry for the inconvenience"
		}        
		</td>
      </tr>
            <tr>
      <td>admin</td>
        <td>GET</td>
        <td>https://codergram.dk/Meew/api/wheel/companies</td>
        <td>
        </td>
        <td>
        [
    {
        "id": Integer,
        "companyName": String
    },...
]
        </td>
        <td>
   	{
    		"code": 500,
    		"message": "Internal Server Problem. We are sorry for the inconvenience"
		}        
		</td>
      </tr>
         <tr>
      <td>admin</td>
        <td>GET</td>
        <td>https://codergram.dk/Meew/api/wheel/spins</td>
        <td>
        </td>
        <td>
 [
 {
    "id": Integer,
    "fieldNumbers": Integer,
    "arcSize": Float,
    "top": Integer,
    "offSet": Float,
    "rotate": Float,
    "resultNumber": Integer,
    "resultName": String,
    "resultValue": Float,
    "player": {
        "id": Integer,
        "playerName": String,
        "email": String
    },
    "wheel": {
        "id": Integer,
        "wheelName": String,
        "fields": [
            {
                "id": Integer,
                "prizeName": String,
                "prizeValue": Float
            },...
        ],
        "company": {
            "id": Integer,
            "companyName": String
        },
        "spins": [
        		{
                    "id": Integer,
                    "resultName": String,
                    "resultValue": Float,
                    "player": {
                        "id": Integer,
                        "playerName": String,
                        "email": String
                    },
                    "date": {
                        "year": Integer,
                        "month": Integer,
                        "day": Integer
                    }
                },...
        ]
    },...
 ]
        </td>
        <td>
   	{
    		"code": 500,
    		"message": "Internal Server Problem. We are sorry for the inconvenience"
		}        
		</td>
      </tr>
               <tr>
      <td>admin</td>
        <td>GET</td>
        <td>https://codergram.dk/Meew/api/wheel/players</td>
        <td>
        </td>
        <td>
 [
    {
        "id": Integer,
        "playerName": String,
        "email": String
    },...
]        </td>
        <td>
   	{
    		"code": 500,
    		"message": "Internal Server Problem. We are sorry for the inconvenience"
		}        
		</td>
      </tr>
    </tbody>
  </table>
  All errors are reported using this format (with the HTTP-status code matching the number) 
<br>
{ "code": statusCode, "message": "Explains the problem" } 


## Cloning this project

1. Initial Setup (Do not open the project in your IDE for anything below)

2. Before you start verify that your local docker-environment is started and startcode_test is available 
3. In a terminal (git bash on Windows) clone the project. CD into the project folder and delete the .git folder and Do "Your own" `git init`
4. In the project folder run this: `mvn clean test`  (make sure your docker environment is up)
5. When everything above is fine, create your OWN repository for the project on github. Commit and Push your code to this repo.
6. Go to Travis-ci.com and Sign up with GitHub
7. Accept the Authorization of Travis CI. You’ll be redirected to GitHub
Click the green Activate button, and select the new repository to be used with Travis CI. Now you are ready for the next steps :-)
8. Deploy the project (manually) via Maven
9. Before you start make sure you have all these details ready (make a small document with the values FIRST)

10. The user you have created on your droplet MySQL server, with GRANTS to all databases:
User:		_________
Password	_________

11. The user you have created to allow deployment on Tomcat 
(On your droplet look in tomcat/tomcat-users.xml if you have forgot):
User:		_________
Password	_________

12. The name to your server https://xxxxxx.dk (make sure you can access /manager/html)

13. Open your project in your IDE, since we have to make a few changes to the code and pom-file
14. Open the pom-file, and locate the properties-section at the start of the file. Change the value for remote.server to a URL pointing to YOUR droplet
On your droplet, either using workbench locally or via the SQL-client on the droplet, create a new database called startcode_demo.
1. ssh into your droplet, and navigate into the root of the cloned docker project
1. Stop your docker-servers: `docker-compose down`
1. With nano, open docker-compose.yml
1. Under the web: section find the lines given below and change USER, and PW to your values, and change CONNECTION_STR to point startcode_demo (If you have an existing Java-project, using a database on your droplet, follow the instructions given in DigitalOcean Setup instructions "Create another database and set environment variables to host additional Java Projects") 
 
1. Crate `CONNECTION_STR: "jdbc:mysql://db:3306/startcode"`
`USER: "dev"`
`PW: "ax2"` 
`DEPLOYED: "PROD"`

1. Save the file, rebuild and run using these commands:
`docker-compose down`
`docker-compose build`
`docker-compose up -d`
1. Back in a LOCAL terminal (git bash on Windows), in the root of the Java-project, type:
`mvn clean test -Dremote.user=USER -Dremote.password=PW tomcat7:deploy`
The values for user and password above, are those YOU have added in tomcat-users.xml during the initial setup of your droplet.

1. HOPEFULLY, those values are NOT admin and admin123, if they are, do the following:
`docker-compose down`
1. With nano, open `tomcat/tomcat-users.xml` Change username and password and save.
1. run `docker-compose build --no-cache`
1. Start the servers again: `docker-compose up -d`
1. If everything was fine the project was deployed to your droplet, ready to use with the remote database. Test like this:
`URL_OR_DomainName/devops-starter/api/xxx/count `

1. Let Travis deploy your project - if it builds and all tests are green
In this step we will let travis deploy our project if it builds and all tests are green :-)

1. Login to Travis using Github, and select your project on the dashboard
1. Click "More options" and select "settings"
1. Create two Environment Variables with names and values as sketched below (two steps)
`REMOTE_USER :  XXXXXX`
`REMOTE_PW :   XXXXXXX`
These are the values you added in step 10-11, when we deployed via maven by yourself. In this part,   since you did it yourself, secrets were not an issue. On Travis it is. So this ensures that no one else can see your credentials
1. Now make a small change to index.html (one that is easy to see after deploy)
1. In a terminal, in the root of the project, type: `mvn clean test` (always build and test before you commit). If everything was fine, commit and push your changes
1. On travis-ci.org verify that your commit has been detected and a "build cycle" has started
1. If everything was fine (might take a few minutes) verify that Travis has deployed your new war file to your droplet

## Show your support

Give a ⭐️ if this project helped you!

## Contributing

Feel free to fork this project and make your changes.

***
_This README was generated with ❤️ by [readme-md-generator](https://github.com/kefranabg/readme-md-generator)_
