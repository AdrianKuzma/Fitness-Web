import { ArticleType } from "./article-type";

export interface Article {
    id: number;
    name: string;
    description: string;
    type: ArticleType;
}