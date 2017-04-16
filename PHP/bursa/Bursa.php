<?php
/**
 * Created by IntelliJ IDEA.
 * User: Tudor
 * Date: 09-Apr-17
 * Time: 8:06 PM
 */

namespace bursa;

include("Apple.php");
include("Google.php");
include("EmptyActiune.php");
//include("Actiune.php");

class Bursa
{
	private $actiuni = [];

	function cumpara($actiune, $numarActiuni)
	{
		$tmpArray = [];
		for ($i = 0; $i < $numarActiuni; $i++) {
			array_push($tmpArray, $this->createActiune($actiune));
		}
		array_merge($this->actiuni, $tmpArray);
		return sprintf("Ai cumparat %d actiuni in valoare de %f\n",
			count($tmpArray), $this->calculeazaValoare($tmpArray));
	}

	function vinde($actiuneUser, $numarActiuni)
	{

	}

	function statistica()
	{

	}

	function calculeazaValoare($actiuni)
	{
		$sum = 0;
		foreach ($actiuni as $it) {
			if ($it instanceof Actiune)
				$sum += $it->pret;
		}
		return $sum;
	}

	function createActiune($companie)
	{
		if (strcasecmp($companie, Apple::$APPLE) == 0)
			return new Apple();
		elseif (strcasecmp($companie, Google::$GOOGLE) == 0)
			return new Google();
		else
			return new EmptyActiune();
	}
}