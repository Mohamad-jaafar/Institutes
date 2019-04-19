#include <stdio.h>
#ifndef HEADERFILE_H
#define HEADERFILE_H
#include "node.h"
#endif
int sum_rcsv (struct Node *head) {

	if (head == NULL) {
		return 0;
	} else {

		return (head -> data) + sum_rcsv(head -> next);
	}
}
