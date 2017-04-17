from hessianlib import Hessian
import sys
class ExecHessClie:
    def __init__(self, urlServ):
        print "Client Hessian Python: " + urlServ
        proxy = Hessian(urlServ)
        # print proxy.cumpara("apple",1)
        # print proxy.cumpara("google",1)
        print proxy.statistica()

ExecHessClie("http://localhost:8081/BursaServer.php")
