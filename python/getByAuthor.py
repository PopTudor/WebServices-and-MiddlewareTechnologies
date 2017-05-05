import requests
import json


uri='http://localhost:8080'
path='/carti?author=ion creanga'

resp = requests.get(uri+path)

for carte in resp.json():
    print json.dumps(carte)