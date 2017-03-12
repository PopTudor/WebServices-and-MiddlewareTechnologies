<?php
/**
 * Created by IntelliJ IDEA.
 * User: Tudor
 * Date: 12-Mar-17
 * Time: 4:42 PM
 */
main($argc, $argv);
function main($argc, $argv) {
	if ($argc <= 1)
		throw new InvalidArgumentException("Trebuie introdus numele fisierului");
	$source = fopen($argv[1], 'r');
	$out = fopen('php_reversed.txt', 'w');
	ftruncate($out, 0);
	$position = filesize(basename($argv[1]));
	for ($line = fgets($source); !empty($line); $line = fgets($source)) {
		$line = str_replace("\n", '', $line);
		$line = strrev($line);
		$position -= strlen($line);
		fseek($out, $position);
		fwrite($out, $line);
	}
	fclose($source);
	fflush($out);
	fclose($out);
}

?>