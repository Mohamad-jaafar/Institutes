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

void print_list_rcsv (struct Node *head) {

	if (head == NULL) {

		printf(">NULL\n");
	} else {

		if (head -> prev == NULL) printf("NULL<");
		print_node (head);
		print_list_rcsv(head -> next);
	}
}
