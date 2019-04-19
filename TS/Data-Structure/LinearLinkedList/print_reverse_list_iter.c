#include <stdio.h>
#ifndef HEADERFILE_H
#define HEADERFILE_H
#include "node.h"
#endif

#ifndef PRINTNODE_H
#define PRINTNODE_H
#include "print_node.h"
#endif

void print_reverse_list_iter (struct Node *n) {

	while (n != NULL) {
		print_node (n);
		n = n -> next;
	}
	printf("NULL\n");
}
