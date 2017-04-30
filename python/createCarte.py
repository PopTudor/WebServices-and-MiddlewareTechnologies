import requests
import json


uri='http://localhost:8080'
path='/carti'

resp = requests.post(uri+path,json = {
    'title':'Morometii',
    'author':'Marin Preda',
    'pret':'20.1'
})
if resp.status_code != 200:
    raise ApiError('POST /carti {}'.format(resp.status_code))
print resp