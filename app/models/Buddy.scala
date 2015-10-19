package models
import javax.persistence._

/**
 * @author kedar.parikh
 */

@Entity
@Table(name = "buddy")
class Buddy(first: String, last: String) {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  var id: Int = _

  var firstName: String = first
  var lastName: String  = last

  def this() = this (null, null)

  override def toString = id + " = " + firstName + " " + lastName
}