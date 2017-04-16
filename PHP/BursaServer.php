<?php

/**
 * Created by IntelliJ IDEA.
 * User: Tudor
 * Date: 09-Apr-17
 * Time: 7:18 PM
 */
include_once("bursa/Bursa.php");
include_once("hessian/src/HessianService.php");

$service = new HessianService(new bursa\Bursa());
$service->handle();