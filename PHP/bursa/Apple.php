<?php
/**
 * Created by IntelliJ IDEA.
 * User: Tudor
 * Date: 09-Apr-17
 * Time: 8:12 PM
 */

namespace bursa;
require("Actiune.php");



class Apple extends Actiune
{
	static $APPLE = "APPLE";
    function __construct() {
        $this->pret = 56.34;
        $this->nume = Apple::$APPLE;
    }

}