import requests
import json


uri='http://localhost:8080'
path='/carti/La Scaldat'

resp = requests.put(uri+path,json = {
    'title':'La Scaldat',
    'author':'Ion Creanga',
    'pret':'23.1'
})

print resp