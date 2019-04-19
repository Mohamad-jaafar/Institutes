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
struct Node * search_rcsv (struct Node *head, int data) {

	if (head == NULL || head -> data == data) {
		return head;
	} else {

		return search_rcsv (head -> next, data);
	}
}
