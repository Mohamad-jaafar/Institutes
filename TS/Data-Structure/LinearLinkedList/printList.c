#include <stdio.h>
#ifndef HEADERFILE_H
#define HEADERFILE_H
#include "node.h"
#endif
void printList (struct Node *n) {

	while (n != NULL) {
		printf(" %d ", n -> data);
		n = n -> next;
	}
	printf("\n");
}
