import requests
import json

uri='http://localhost:8080'
path='/carti'
resp = requests.get(uri+path)

for carte in resp.json():
    print json.dumps(carte)