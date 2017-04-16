<?php
/**
 * Created by IntelliJ IDEA.
 * User: Tudor
 * Date: 09-Apr-17
 * Time: 8:12 PM
 */

namespace bursa;


class EmptyActiune extends Actiune
{

	function __construct()
	{
		$this->pret = 0.0;
		$this->nume = "Empty";
	}
}