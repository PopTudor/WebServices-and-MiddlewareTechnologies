<?php
/**
 * Created by IntelliJ IDEA.
 * User: Tudor
 * Date: 09-Apr-17
 * Time: 7:55 PM
 */
include_once("hessian/src/HessianClient.php");
require_once("bursa/Apple.php");
require_once("bursa/Actiune.php");

class BursaClientPHP
{
    function __construct($urlServ)
    {
        echo "Client Hessian PHP: " . $urlServ . "<br/>\n";
        $bursa = new HessianClient($urlServ);

        echo $bursa->cumpara("APPLE", 5);
//        echo $bursa->cumpara("google", 3);
//        echo $bursa->cumpara("google", 1);
		echo $bursa->vinde("apple",1);
        echo $bursa->statistica();
    }
}

if (isset($_GET["urlServ"]))
    new BursaClientPHP($_GET["urlServ"]); //http://localhost:8080/exec
else
    new BursaClientPHP("http://localhost:8081/BursaServer.php");
?>
