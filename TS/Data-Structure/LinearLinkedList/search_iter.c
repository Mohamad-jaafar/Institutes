#include <stdio.h>
#ifndef HEADERFILE_H
#define HEADERFILE_H
#include "node.h"
#endif
struct Node * search_iter (struct Node *head, int val) {

	struct Node *cursor = head;

	while (cursor != NULL) {
		if (cursor -> data == val)
			return cursor;
		cursor = cursor -> next;
	}
	return NULL;
}
