import requests
import json


uri='http://localhost:8080'
path='/carti'

resp = requests.post(uri+path,json = {
    'title':'Morometii',
    'author':'Marin Preda',
    'pret':'20.1'
})

print resp