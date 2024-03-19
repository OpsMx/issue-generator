    
   test auto trigger
   checking master commits details..this is for demo. 4/11/22 -ravig
   testing
   
   checking master commits details..this is for demo.
   this is for demo
# Issuegen 
This rest app you can use for generating log and metric data using api as well as UI also for    
* API List   
*               
  - /greeting   
  - /issues  
  - /dogcount
  - /catcount 
  - /logs?type=''
  - /issue?type=''
  - /warn?type=''      
     
## Get a html page
    
### Request  
  
`GET /greeting/` 

    curl -i -H 'Accept: application/json' http://localhost:8080/greeting/
    
 GET /`

    curl -i -H 'Accept: application/json' http://localhost:8080 
    
### Response
    HTTP/1.1 200 OK
    HTML Page 
## Rest APIs
### Request  cbcb
`GET /dogcount`

    curl -i -H 'Accept: application/json' http://localhost:8080/dogcount

### Response  

    { "dogCount": 16 }

### Request

`GET /catcount`

    curl -i -H 'Accept: application/json' http://localhost:8080/catcount

### Response

    { "catCount": 20 }

### Request  

`GET /issues/`

    curl -i -H 'Accept: application/json' http://localhost:8080/issues?issue='INFO'
    
 GET /logs?type='INFO'

    curl -i -H 'Accept: application/json' http://localhost:8080/logs?type='INFO'
    
    list of request param values 
       - CRITICAL
       - DEBUG
       - ERROR
       - WARN
       - INFO
       
### Request for specific errors 
    
 GET /issue?type='OUT_OF_MEMORY'

    curl -i -H 'Accept: application/json' http://localhost:8080/issue?type='OUT_OF_MEMORY'
    
    list of request param values 
       - OUT_OF_MEMORY
       - STACK_OVERFLOW_ERROR
       - FILE_NOT_FOUND
       - ARRAY_INDEX_OUT_OF_BOUND
       - NULL_POINTER
       - STRING_INDEX_OUT_OF_BOUND
       - NO_CLASS_DEF_FOUND
       - NO_SUCH_METHOD_FOUND
       - NUMBER_FORMAT
       - ILLEGAL_ARGUMENT 
       - CLASS_NOT_FOUND
       
 ### Request for specific warnings
    
 GET /warn?type='GARBAGE_COLLECTION'

    curl -i -H 'Accept: application/json' http://localhost:8080/warn?type='GARBAGE_COLLECTION'
    
    list of request param values 
       - GARBAGE_COLLECTION
       - DEPRECATED_API
       - VERSION
   #demo    
       
#dmo webhook
#### description
will create a log of type issue 
valid input for issue are CRITICAL,ERROR,DEBUG,WARN,INFO
defalult log will be of type info

#### slack demo for test...

update
##demo webhook trigger

## trigger issuegen - 24 jun 2022

issuegen-pipeline
pipeline

webhook test
https://www.linkedin.com/pulse/automate-jenkins-build-job-srikant-pandey

Done!
