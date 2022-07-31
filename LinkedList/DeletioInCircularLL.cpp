#include <bits/stdc++.h>
using namespace std;

struct Node
{
    int data;
    struct Node *next;
    Node(int data)
    {
        this->data=data;
        next=NULL;
    }
};

Node *deleteNode(Node *head, int val)
{
    // case1 - if head is null: return null
    // case2 - if val is last elt then traverse and track prev to last pointer. prev->next=head.
    // case3 - if val is first elt: traverse till last elt (curr->next!=head) curr->next=head->next; head=head->next;
    // case4 - if any other node: curr->next->data == val then curr->next=curr->next->next;

    if(head==NULL)
        return head;
    
    
    // case 2.
    Node *curr=head, *prev=head;

    if(head->data==val) // head is val
    {
        while(curr->next!=head)
        {
            curr=curr->next;
        }
        // this will stop at last node.
        curr->next=head->next;
        head=head->next;
    }
    else
    {
        //cout<<"for middle and last cases\n";

        while(curr->next!=head)
        {
        
            if(curr->data==val) // middle values.
            {
                break;
            }
            prev=curr;
            curr=curr->next;
        }
        prev->next=curr->next; // handles both last and middle value deletion cases.
    }

    return head;
}


void printList(Node *head)
{
    Node *curr=head;
    while(curr->next!=head)
    {
        cout<<curr->data<<" ";
        curr=curr->next;
    }
    cout<<curr->data<<" ";
    cout<<"\n";
}

int main()
{
    Node *head=new Node(1);
    head->next=new Node(2);
    head->next->next=new Node(3);
    head->next->next->next=new Node(4);
    head->next->next->next->next=new Node(5);
    head->next->next->next->next->next=new Node(6);
    head->next->next->next->next->next->next=new Node(7);
    head->next->next->next->next->next->next->next=head;

    int del1=1, del2=4,  del3=7;

    cout<<"original list: ";
    printList(head);

    Node *temp=deleteNode(head, del1);
    cout<<"after deleting 1st node: ";
    printList(temp);

    temp=deleteNode(temp, del2);
    cout<<"after deleting middle node: ";
    printList(temp);
    
    temp=deleteNode(temp, del3);
    cout<<"after deleting last node: ";
    printList(temp);

    return 0;
}