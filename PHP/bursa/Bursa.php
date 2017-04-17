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

class Bursa
{
	var $actiuni;

	/**
	 * Bursa constructor.
	 */
	public function __construct()
	{
		$this->actiuni = $this->getActiuniFromFile();
	}

	function getActiuniFromFile()
	{
		return json_decode(file_get_contents("ar.txt", true));
	}

	function saveActiuniToFile($array)
	{
		file_put_contents("ar.txt", json_encode($array), LOCK_EX);
	}

	function cumpara($actiune, $numarActiuni)
	{
		$tmpArray = [];
		for ($i = 0; $i < $numarActiuni; $i++)
			array_push($tmpArray, $this->createActiune($actiune));
		$this->actiuni = array_merge($this->actiuni, $tmpArray);
		$this->saveActiuniToFile($this->actiuni);
		return sprintf("Ai cumparat %d actiuni in valoare de %f\n", count($tmpArray), $this->calculeazaValoare($tmpArray));
	}

	function vinde($actiuneUser, $numarActiuni)
	{
		$sum = 0.0;
		$count = 0;
		for ($i = 0; i < count($this->actiuni) && $count < $numarActiuni; $i++) {
			$actiune = $this->actiuni[$i];
			if ($actiune instanceof Actiune) {
				if (strcasecmp($actiune->nume, $actiuneUser)) {
					$sum += $actiune->pret;
					unset($this->actiuni[$i]);
					$count++;
				}
			}
		}
		$this->saveActiuniToFile($this->actiuni);
		return sprintf("Ai vandut %d actiuni in valoare de %s$", $count, $sum);
	}

	function statistica()
	{
		$resultString = "Status:\n";
		$resultString .= "Numar actiuni: " . count($this->actiuni) . "\n";
		$resultString .= "Actiuni: " . json_encode($this->actiuni);
		return $resultString;
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