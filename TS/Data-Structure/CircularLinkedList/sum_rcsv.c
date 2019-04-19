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
int sum_rcsv (struct Node *head) {

	if (head == NULL) {
		return 0;
	} else {

		return (head -> data) + sum_rcsv(head -> next);
	}
}
