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
	for ($character = fgetc($source); !empty($character); $character = fgetc($source)) {
		$position--;
		if ($character == "\n") $character = ' ';

		fseek($out, $position);
		fwrite($out, $character);
	}
	fclose($source);
	fflush($out);
	fclose($out);
}

?>