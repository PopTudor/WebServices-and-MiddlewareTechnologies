import requests
import json

uri='http://localhost:8080'
path='/carti/La Scaldat'

resp = requests.get(uri+path)

print json.dumps(resp.json())