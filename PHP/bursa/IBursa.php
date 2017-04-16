<?php
/**
 * Created by IntelliJ IDEA.
 * User: Tudor
 * Date: 09-Apr-17
 * Time: 8:06 PM
 */

namespace bursa;


class IBursa
{
    public $actiuni = [];

    function cumpara($actiune, $numarActiuni)
    {
        $tmpArray = [];
        for ($i = 0; $i < $numarActiuni; $i++)
            array_push($tmpArray, $actiune);
        array_push($this->actiuni, $tmpArray);
        return sprintf("Ai cumparat %d actiuni in valoare de %s", count($tmpArray), calculeazaValoare($tmpArray));
    }

    function vinde($actiuneUser, $numarActiuni)
    {

    }

    function statistica()
    {

    }

    function calculeazaValoare($array)
    {
        $sum = 0;
        foreach ($array as $item)
            $sum += $item->price;
        return $sum;
    }
}