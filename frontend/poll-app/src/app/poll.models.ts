export interface OptionVote {
    optionText: string;
    voteCount: number;
}


export interface Poll {
    id: number;
    questions: string;
    options: OptionVote[];
}
