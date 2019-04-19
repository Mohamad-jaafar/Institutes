#include <stdio.h>
#ifndef HEADERFILE_H
#define HEADERFILE_H
#include "node.h"
#endif

#ifndef PRINTNODE_H
#define PRINTNODE_H
#include "print_node.h"
#endif

void print_list_rcsv (struct Node *head) {

	if (head == NULL) {

		printf("NULL\n");
	} else {
		print_node (head);
		print_list_rcsv(head -> next);
	}
}
