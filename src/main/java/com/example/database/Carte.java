package com.example.database;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by tudor on 29/04/2017.
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Carte {
    String title;
    String author;
	double pret;
	int id;
}
