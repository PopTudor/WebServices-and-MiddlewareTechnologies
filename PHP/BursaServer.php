<?php

/**
 * Created by IntelliJ IDEA.
 * User: Tudor
 * Date: 09-Apr-17
 * Time: 7:18 PM
 */
include_once("bursa/IBursa.php");

class HessServer
{
	function ping()
	{
		return "PHP Hessian Serv " . $_SERVER["SERVER_NAME"] . " (" .
			gethostbyname($_SERVER["SERVER_NAME"]) . ":" .
			$_SERVER["SERVER_PORT"] . "), " . date("Y.m.d H:i:s");
	}

	public $actiuni = [];

	function cumpara($actiune, $numarActiuni)
	{
		$tmpArray = [];
		for ($i = 0; $i < $numarActiuni; $i++)
			array_push($tmpArray, $actiune);
		array_push($this->actiuni, $tmpArray);
		return sprintf("Ai cumparat %d actiuni in valoare de %s", count($tmpArray), calculeazaValoare($tmpArray));
	}
}

include_once("hessian/src/HessianService.php");

$service = new HessianService(new HessServer());
$service->handle();