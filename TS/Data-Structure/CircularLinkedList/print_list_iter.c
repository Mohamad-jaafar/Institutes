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

void print_list_iter (struct Node *head) {

	struct Node *cursor = head;

	if (head != NULL){
		do {
			print_node(cursor);
			cursor = cursor -> next;
		} while (cursor != head);
	}
	printf("\n");
}
