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
	$out = fopen("php" . rand(0, 100) . "_reversed.txt", 'w');
	ftruncate($out, 0);
	$position = filesize(basename($argv[1]));
	for ($octet = fread($source, 1); !empty($octet); $octet = fread($source, 1)) {
		$position--;
		fseek($out, $position);
		fwrite($out, $octet);
	}
	fclose($source);
	fflush($out);
	fclose($out);
}

?>