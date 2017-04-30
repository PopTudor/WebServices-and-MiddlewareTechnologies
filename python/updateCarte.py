import requests
import json


uri='http://localhost:8080'
path='/carti/La Scaldat'

resp = requests.put(uri+path,json = {
    'title':'La Scaldat',
    'author':'Ion Creanga',
    'pret':'23.1'
})
if resp.status_code != 200:
    raise ApiError('put /carti {}'.format(resp.status_code))
print resp