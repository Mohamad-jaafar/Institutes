#include <stdio.h>
#ifndef HEADERFILE_H
#define HEADERFILE_H
#include "node.h"
#endif

#ifndef PRINTNODE_H
#define PRINTNODE_H
#include "print_node.h"
#endif

void print_list_iter (struct Node *head) {

	struct Node * cursor = head;
	while (cursor != NULL) {
		print_node (cursor);
		cursor = cursor -> next;
	}
	printf("NULL\n");
}
