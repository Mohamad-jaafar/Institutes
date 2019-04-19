#include <stdio.h>
#ifndef HEADERFILE_H
#define HEADERFILE_H
#include "node.h"
#endif
int length_iter (struct Node *head) {

	int counter = 0;
	struct Node * cursor = head;

	while (cursor != NULL) {
		counter ++;
		cursor = cursor -> next;
	}
	return counter;
}
