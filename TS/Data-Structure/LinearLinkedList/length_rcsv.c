#include <stdio.h>
#ifndef HEADERFILE_H
#define HEADERFILE_H
#include "node.h"
#endif
int length_rcsv (struct Node *head) {

	if (head == NULL) {
		return 0;
	} else {

		return 1 + length_rcsv(head -> next);
	}
}
