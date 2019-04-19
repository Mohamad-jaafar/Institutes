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

void print_reverse_list_rcsv (struct Node *head) {

	if (head == NULL) {

		printf("NULL");
	} else {
		print_reverse_list_rcsv (head -> next);
		print_reverse_node (head);

		// The counter is just to print newline at the end
		if (head -> prev == NULL) printf(">NULL\n");
	} 
}
