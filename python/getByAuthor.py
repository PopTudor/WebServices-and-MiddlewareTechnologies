import requests
import json


uri='http://localhost:8080'
path='/carti?author=ion creanga'

resp = requests.get(uri+path)
if resp.status_code != 200:
    # This means something went wrong.
    raise ApiError('GET /carti {}'.format(resp.status_code))
for carte in resp.json():
    print json.dumps(carte)