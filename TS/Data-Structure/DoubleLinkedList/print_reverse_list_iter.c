/*
 * Created on: Apr 11, 2019
 * Author: Mohamad-Jaafar NEHME
 * Email: mohamad.jaafar.nehme[att]gmail(.)com
 */

#include <stdio.h>
#ifndef NODE_H
#define NODE_H
#include "node.h"
#endif

#ifndef PRINTNODE_H
#define PRINTNODE_H
#include "print_node.h"
#endif

void print_reverse_list_iter (struct Node *head) {

	printf("NULL<");
	struct Node *cursor = head;

	// Go to the end
	while (cursor -> next != NULL) {
		cursor = cursor -> next;
	}

	//Start from end to head
	while (cursor != NULL) {
		print_node (cursor);
		cursor = cursor -> prev;
	}
	printf(">NULL\n");
}
