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
