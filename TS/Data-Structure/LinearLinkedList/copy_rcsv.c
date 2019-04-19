#include <stdio.h>
#ifndef HEADERFILE_H
#define HEADERFILE_H
#include "node.h"
#endif
struct Node * copy_rcsv (struct Node *n) {

	if (n == NULL) {
		return NULL;
	} else {
		struct Node * newnode;
		newnode = (struct Node *) malloc (sizeof(struct Node));
		newnode -> data = n -> data;
		newnode -> next = copy_rcsv (n -> next);
	}
}
