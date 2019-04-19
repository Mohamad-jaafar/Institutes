#include <stdio.h>
#ifndef HEADERFILE_H
#define HEADERFILE_H
#include "node.h"
#endif
struct Node * search_rcsv (struct Node *n, int data) {

	if (n == NULL || n -> data == data) {
		return n;
	} else {

		return search_rcsv (n -> next, data);
	}
}
