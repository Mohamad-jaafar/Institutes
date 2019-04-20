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
struct Node * search_iter (struct Node *head, int val) {

	if (head == NULL)
		return NULL;

	else if (head -> next == head) 
		return head;

	else{

		struct Node * cursor = head -> next;
		while (cursor != head) {
			if (cursor -> data == val)
				return cursor;
			cursor = cursor -> next;
		}
		return NULL;
	}
}
