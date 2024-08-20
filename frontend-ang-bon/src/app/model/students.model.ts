export interface Student {
    id: String,
    code: String,
    firstName: String,
    lastName: String,
    programId: String,
    photo: String,

}

export interface Payment {
    id: String,
    date: String,
    amount: Number,
    type: String,
    status: String,
    file: String,
    student: Student
}

export enum PaymentType {
    CASH, CHECK, TRANSFER, DEPOSIT
}

export enum PaymentStatus {
    CREATED, VALIDATED, REJECTED
}